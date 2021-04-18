package uk.board.Controller;


import javassist.bytecode.ClassFile;
import uk.board.service.posts.PostsService;

import uk.board.service.posts.PostsService;
import uk.board.dto.PostsResponseDto;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import javax.servlet.http.HttpSession;

//URL을 mapping 해주는 Controller 생성.
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
//        if (user != null) {
//            model.addAttribute("userName", user.getName());
//        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}