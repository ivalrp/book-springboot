package com.subrutin.catalog.service;

import com.subrutin.catalog.domain.Author;
import com.subrutin.catalog.dto.AuthorCreateRequestDTO;
import com.subrutin.catalog.dto.AuthorResponseDTO;
import com.subrutin.catalog.dto.AuthorUpdateRequestDTO;

import java.util.List;

public interface AuthorService {

    public AuthorResponseDTO findAuthorById(String id);

    public void createNewAuthor(List<AuthorCreateRequestDTO> dto);

    public void updateAuthor(String authorId, AuthorUpdateRequestDTO dto);

    public void deleteAuthor(String authorId);

    public List<Author> findAuthors(List<String> authorIdList);

    public List<AuthorResponseDTO> constructDTO(List<Author> authors);
}
