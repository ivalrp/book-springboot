package com.subrutin.catalog.service;

import com.subrutin.catalog.dto.AuthorCreateRequestDTO;
import com.subrutin.catalog.dto.AuthorResponseDTO;
import com.subrutin.catalog.dto.AuthorUpdateRequestDTO;

import java.util.List;

public interface AuthorService {

    public AuthorResponseDTO findAuthorById(Long id);

    public void createNewAuthor(List<AuthorCreateRequestDTO> dto);

    public void updateAuthor(Long authorId, AuthorUpdateRequestDTO dto);

    public void deleteAuthor(Long authorId);
}
