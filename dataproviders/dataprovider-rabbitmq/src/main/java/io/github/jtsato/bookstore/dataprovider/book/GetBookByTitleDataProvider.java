package io.github.jtsato.bookstore.dataprovider.book;

import java.util.Optional;

import org.springframework.stereotype.Service;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.book.gateway.GetBookByTitleGateway;

/**
 * @author Jorge Takeshi Sato
 */

@Service
public class GetBookByTitleDataProvider implements GetBookByTitleGateway {

    @Override
    public Optional<Book> getBookByTitle(final String title) {
        return Optional.empty();
    }
}
