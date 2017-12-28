package avatar.controller;

import avatar.model.AvatarModel;
import org.springframework.web.bind.annotation.*;

@RestController
public class AvatarController {

    @GetMapping("/avatar")
    public AvatarModel getAvatar(@ModelAttribute("avatarString") String avatarString) {
        String url = "https://robohash.org/" + avatarString;
        return new AvatarModel(url);
    }
}
