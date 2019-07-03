package com.cheer.SpringMVC.thymeleaf.web.controller;

import com.cheer.spring.mybatis.pojo.Emp;
import com.cheer.spring.mybatis.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("username", "admin");
        return "index";
    }


    @GetMapping("/getEmpList")
    public String getEmpList(Model model){
        List<Emp> list = this.empService.getList();
        for (Emp emp : list) {
            System.out.println(emp);
        }
        model.addAttribute("emplist",list);
        return "getEmpList";
    }

    @GetMapping("/delete/{empno}")
    public String deltet(@PathVariable Integer empno){
        int delete = this.empService.delete(empno);
        return "redirect:/getEmpList";
    }

    @GetMapping("/update/{empno}")
    public String getEmp(@PathVariable Integer empno,Model model){
        Emp emp = this.empService.getEmp(empno);
        model.addAttribute("emp",emp);
        return "update";
    }

    @PostMapping("/update1")
    public String getEmp1(Emp emp){
        int update = this.empService.update(emp);
        return "redirect:/getEmpList";
    }

    /**
     * 转发到inseret方法
     * @return
     */
    @RequestMapping("/insert")
    public String insert(){
        return "insert";
    }

    /**
     * 添加功能
     * @param emp 传入对象插入数据库中
     * @return
     */
    @PostMapping("/insert")
    public String insert2(Emp emp){

        int insert = empService.insert(emp);

        return "redirect:/getEmpList";
    }
}
