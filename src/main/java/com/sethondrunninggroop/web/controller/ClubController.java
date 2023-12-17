package com.sethondrunninggroop.web.controller;

import com.sethondrunninggroop.web.dto.ClubDto;
import com.sethondrunninggroop.web.models.Club;
import com.sethondrunninggroop.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class ClubController {

    private ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String listClubs(Model model){
        List<ClubDto> clubs = clubService.findAllClubs();
        model.addAttribute("clubs",clubs);
        return "clubs-list";
    }
    @GetMapping("/clubs/{clubId}")
    public String clubDetail(@PathVariable("clubId") long clubId, Model model){
        ClubDto clubDto  = clubService.findClubById(clubId);
        model.addAttribute("club", clubDto);
        return "clubs-detail";
    }

    @GetMapping("/clubs/new")
    public String createClubForm(Model model){
        Club club = new Club();
        model.addAttribute("club",club);
        return "clubs-create";
    }
    @GetMapping("/clubs/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId") Long clubId){
        clubService.delete(clubId);
        return "redirect:/clubs";
    }
    @GetMapping("/clubs/search")
    public String searchClub(@RequestParam(value = "query") String query, Model model){
        List<ClubDto> clubs = clubService.searchClub(query);
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }


    @PostMapping("/clubs/new")
    public String saveClub(@ModelAttribute("club") Club club){
        clubService.saveClub(club);
        return "redirect:/clubs";
    }
    @GetMapping("clubs/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") long clubId, Model model ){
        ClubDto club = clubService.findClubById(clubId);
        model.addAttribute("club", club);
        return "clubs-edit";
    }
    @PostMapping("/clubs/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") Long clubId,
                             @ModelAttribute("club") ClubDto club){
        club.setId(clubId);
        clubService.updateClub(club);
        return "redirect:/clubs";
    }
}
