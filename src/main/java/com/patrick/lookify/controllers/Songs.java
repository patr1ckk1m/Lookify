package com.patrick.lookify.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.patrick.lookify.models.Song;
import com.patrick.lookify.services.SongService;

@Controller
public class Songs {
	
	private final SongService songService;
	
	public Songs(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "dashboardPage.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String addSong(@ModelAttribute("song") Song song, @ModelAttribute("errors") String errors, Model model) {
		model.addAttribute("errors", errors);
		return "addSong.jsp";
	}
	
	@PostMapping("/songs/new")
	public String saveSong(@Valid @ModelAttribute("song") Song song, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("errors", "Song and artist must be at least 5 characters");
			return "redirect:/songs/new";
		}else {
			songService.addSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/songs/delete/{id}")
	public String destroySong(@PathVariable("id") Long id) {
		songService.destroySong(id);
		return "redirect:/dashboard";
	}
	
}
