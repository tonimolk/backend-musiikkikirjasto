package s24.backend.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import s24.backend.domain.GenreRepository;
import s24.backend.domain.Song;
import s24.backend.domain.SongRepository;


@Controller
public class SongController {
    @Autowired
    private SongRepository songrepository;
    @Autowired
    private GenreRepository genrerepository;

    @GetMapping(value = "/songlist")
    public String studentList(Model model) {
    model.addAttribute("Songs", songrepository.findAll());
    return "songlist";
    }
    @GetMapping(value = "/songs")
    public @ResponseBody List<Song>  BookListRest() {	
        return (List<Song>) songrepository.findAll();
    }
    @GetMapping(value="/songs/{id}")
    public @ResponseBody Optional<Song> findBookRest(@PathVariable("id") Long songId) {	
    	return songrepository.findById(songId);
    }   
    @GetMapping(value = "/add")
    public String addStudent(Model model) {
        model.addAttribute("Songs", new Song());
        model.addAttribute("Genres", genrerepository.findAll());
        return "addsong";
    }
    @PostMapping(value = "/save")
    public String save(Song song) {
        songrepository.save(song);
        return "redirect:/songlist";
    }
    @GetMapping(value = "/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long songid, Model model) {
        songrepository.deleteById(songid);
        return "redirect:/songlist";
    }
    @GetMapping(value = "/main")
    public String mainPage(){
        return "main";
    }
    
}

