package io.github.jtsato.bookstore.dataprovider.book;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jtsato.bookstore.core.book.domain.BookDocument;
import io.github.jtsato.bookstore.core.book.gateway.SaveBookDocumentGateway;
import io.github.jtsato.bookstore.dataprovider.book.domain.BookDocumentEntity;
import io.github.jtsato.bookstore.dataprovider.book.mapper.BookDocumentMapper;
import io.github.jtsato.bookstore.dataprovider.book.repository.BookDocumentRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class SaveBookDocumentDataProvider implements SaveBookDocumentGateway {

    private final BookDocumentMapper bookDocumentMapper = Mappers.getMapper(BookDocumentMapper.class);
    
    @Autowired
    BookDocumentRepository bookDocumentRepository;

    @Override
    public BookDocument execute(final BookDocument bookDocument) {
        final BookDocumentEntity bookDocumentEntity = bookDocumentMapper.of(bookDocument);
        return bookDocumentMapper.of(bookDocumentRepository.saveAndFlush(bookDocumentEntity));
    }
}
