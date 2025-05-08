package com.exercise.zully.infrastructure.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.zully.aplication.service.ChapterService;
import com.exercise.zully.domain.Chapter;
import com.exercise.zully.domain.dto.ChapterRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping(value = "/api" , produces = MediaType.APPLICATION_JSON_VALUE)
public class ChapterController {

    private final ChapterService chapterService;

    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping("/chapter")
    public List<Chapter> findAllChapters() {
        return chapterService.findAllChapters();
    }

    @GetMapping("/chapter/{id}")
    public ResponseEntity<Chapter> findChapterById(@PathVariable Integer id) {
        Chapter chapter = chapterService.findChapterById(id);
        if(chapter == null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(chapter);
    }

    @PostMapping("/chapters")
    public ResponseEntity<String> createChapter(@RequestBody ChapterRequest chapterRequest){
        boolean created = chapterService.createChapter(chapterRequest);
        if(created){
            return ResponseEntity.ok("Capitulo creado");
        } else{
            return ResponseEntity.badRequest().body("No se pudo crear el capítulo");
        }
    }

    @DeleteMapping("/chapters/{id}")
    public ResponseEntity<String> deleteChapter(@PathVariable Integer id){
        boolean deleted = chapterService.deleteChapter(id);
        if(deleted){
            return ResponseEntity.ok("Capitulo eliminado");
        } else {
            return ResponseEntity.badRequest().body("No se pudo eliminar los capitulos");
        }
    }

    @PutMapping("/chapters/{id}")
    public ResponseEntity<String> updateChapter(@PathVariable Integer id, @RequestBody ChapterRequest chapterRequest) {
        chapterRequest.setId(id);
        boolean updated = chapterService.updateChapter(chapterRequest);
        if(updated){
            return ResponseEntity.ok("Capitulo actualizado");
        } else {
            return ResponseEntity.badRequest().body("No se pudo actualizar el capitulo.");
        }
    }
    
}
