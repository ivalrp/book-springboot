package com.subrutin.catalog.web;

import com.subrutin.catalog.domain.Author;
import com.subrutin.catalog.dto.AuthorCreateRequestDTO;
import com.subrutin.catalog.dto.AuthorResponseDTO;
import com.subrutin.catalog.dto.AuthorUpdateRequestDTO;
import com.subrutin.catalog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorResource {

    private final AuthorService authorService;

    @GetMapping("/author/{id}/detail")
    public ResponseEntity<AuthorResponseDTO> findAuthorById(@PathVariable("id") Long id){
        AuthorResponseDTO result = authorService.findAuthorById(id);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/author")
    public ResponseEntity<Void> createNewAuthor(@RequestBody @Valid List<AuthorCreateRequestDTO> dto){
        authorService.createNewAuthor(dto);
        return ResponseEntity.created(URI.create("/author")).build();
    }

    @PutMapping("/author/{authorId}")
    public ResponseEntity<Void> updateAuthor(@PathVariable("authorId") Long authorId,
                                             @RequestBody AuthorUpdateRequestDTO dto){
        authorService.updateAuthor(authorId, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/author/{authorId}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable("authorId") Long authorId){
        authorService.deleteAuthor(authorId);
        return ResponseEntity.ok().build();
    }


}
