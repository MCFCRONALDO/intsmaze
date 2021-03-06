package cn.intmsaze.project;

import org.intsmaze.common.util.Result;
import org.intsmaze.common.util.ResultGenerator;
import cn.intmsaze.project.model.Person;
import cn.intmsaze.project.service.DubboService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
* Created by CodeGenerator on 2018/03/30.
*/
@RestController
@RequestMapping("/person")
//@CrossOrigin
public class PersonController {
    @Resource
    private DubboService dubboService;

    @RequestMapping("/get/{id}")
    public Result detail(HttpServletResponse response,@PathVariable Integer id) {
    	System.out.println("asdasdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//    	response.addHeader("Access-Control-Allow-Origin", "*");//或者添加@CrossOrigin注解即可解决跨域问题或在WebMvcConfigurer类中使用addCorsMappings()
    	Person person = dubboService.findById(id);
        return ResultGenerator.genSuccessResult(person);
    }

   
}

