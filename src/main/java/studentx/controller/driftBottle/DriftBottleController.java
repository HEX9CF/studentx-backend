package studentx.controller.driftBottle;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import studentx.pojo.DriftBottle;
import studentx.pojo.Result;
import studentx.service.DriftBottleService;

/**
 * 漂移瓶控制器
 * ps: 六一儿童节快乐
 *
 * @author HEX9CF
 * @date 2024/06/01
 */
@Slf4j
@RestController
@RequestMapping("/api/driftBottle")
public class DriftBottleController {
    @Autowired
    private DriftBottleService driftBottleService;

    /**
     * 随机获取
     *
     * @return {@link Result }
     */
    @GetMapping
    public Result getRandom(){
        log.info("获取随机漂流瓶");

        DriftBottle driftBottle = driftBottleService.getRandomByStatus(0);
        if(driftBottle == null){
            return Result.error("获取失败，没有漂流瓶", null);
        }
        return Result.success(driftBottle);
    }

    /**
     * 发送
     *
     * @param driftBottle 漂流瓶
     * @return {@link Result }
     */
    @PostMapping
    public Result send(@RequestBody DriftBottle driftBottle){
        log.info("发送漂流瓶：{}", driftBottle);

        // 验证必填项
        if(driftBottle.getUserId() == null){
            return Result.error("发送失败，用户id不能为空", null);
        }
        if(driftBottle.getMessage() == null || driftBottle.getMessage().isEmpty()){
            return Result.error("发送失败，消息不能为空", null);
        }

        DriftBottle driftBottleNew = new DriftBottle();
        driftBottleNew.setUserId(driftBottle.getUserId());
        driftBottleNew.setMessage(driftBottle.getMessage());
        driftBottleNew.setStatus(1);
        driftBottleService.add(driftBottleNew);
        return Result.success("发送成功", null);
    }

    /**
     * 捡起
     *
     * @param id 身份证件
     * @return {@link Result }
     */
    @PutMapping("{id}")
    public Result pick(@PathVariable Integer id){
        log.info("捡起漂流瓶：{}", id);

        DriftBottle driftBottleNew = driftBottleService.getById(id);
        if(driftBottleNew == null){
            return Result.error("捡起失败，漂流瓶不存在", null);
        }
        if(driftBottleNew.getStatus() != 1){
            return Result.error("捡起失败，漂流瓶已被捡起", null);
        }

        // 捡起漂流瓶
        driftBottleNew.setStatus(2);
        driftBottleService.modify(driftBottleNew);
        return Result.success("捡起成功", null);
    }
}
