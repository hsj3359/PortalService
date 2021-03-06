package kr.ac.jejunu.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rest")
@RequiredArgsConstructor
public class RestController {
    public final UserDao userDao;

    @GetMapping("/{id}")
    public @ResponseBody User get(@PathVariable("id") Integer id){
        return userDao.get(id);
    }
    @PostMapping
    public @ResponseBody User create(@RequestBody User user){
        userDao.insert(user);
        return user;
    }

}
