package qmstore.user.controller;

import org.springframework.web.bind.annotation.*;
import qmstore.user.annotation.DataAuth;
import qmstore.user.condition.LoginCondition;
import qmstore.user.condition.RegisterCondition;
import qmstore.user.manager.impl.UserManagerImpl;
import qmstore.user.pojo.User;
import qmstore.util.Response;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserManagerImpl userManager;

    @PostMapping("/login")
    public Response userLogin(@RequestBody LoginCondition loginCondition){
        try {
            return userManager.UserLogin(loginCondition.getUserId(), loginCondition.getPassword());
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @GetMapping("checkLoginStatus")
    public Response checkLoginStatus(@DataAuth User dataAuth){
        System.out.println("dataAuth = " + dataAuth);
        return Response.SUCCESS(dataAuth);
    }

    @PostMapping("register")
    public Response userRegister(@RequestBody RegisterCondition user){
        try {
            return userManager.UserRegister(user);
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @PostMapping("updateUser")
    public Response updateUser(@RequestBody RegisterCondition user){
        try {
            return userManager.changeUser(user);
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }



}
