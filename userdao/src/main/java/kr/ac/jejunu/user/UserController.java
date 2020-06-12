package kr.ac.jejunu.user;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserDao userDao;


    @RequestMapping(value = "/user")
    public @ModelAttribute User getUser(@RequestParam("id") Integer id){
        return userDao.get(id);
    }
    @RequestMapping("/exception")
    public  void exceprion(){
        throw new RuntimeException("어이쿠!!");
    }





    @RequestMapping(path="/upload", method = RequestMethod.GET)
    public void upload(){

    }
    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public ModelAndView upload(@RequestParam("file")MultipartFile file, HttpServletRequest request) throws IOException {
        File path = new File(request.getServletContext().getRealPath("/")+"/WEB-INF/static/"+file.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(file.getBytes());
        bufferedOutputStream.close();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url","/images"+file.getOriginalFilename());
        return  modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView error(Exception e){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("e",e);
        return modelAndView;
    }

}
