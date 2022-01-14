package org.springframework.samples.petclinic.feeding;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FeedingController {

    @Autowired
    FeedingService fr;

    @Autowired
    public FeedingController(FeedingService fr) {
        this.fr = fr;
    }

    @GetMapping("/feeding/create")
    public String createForm(ModelMap model) {
        model.put("feeding", new Feeding());
        return "feedings/createOrUpdateFeedingForm";
    }

    @PostMapping("/feeding/create")
    public String createUpdateForm(@Valid Feeding fd, BindingResult result, ModelMap model) {
        if(result.hasErrors()) {
            return "feedings/createOrUpdateFeedingForm";
        } else {
            try {
                this.fr.save(fd);
                return "redirect:/welcome";
            } catch(UnfeasibleFeedingException e) {
                System.out.println("Error");
                return "feedings/createOrUpdateFeedingForm";
            }
        }
    }
    
}
