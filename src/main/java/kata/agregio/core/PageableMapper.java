package kata.agregio.core;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PageableMapper {
    public <T> PageableDto<T> convertToDto(Page<T> page) {
        return new PageableDto<>(page.getContent(), page.getTotalPages(), page.getTotalElements(), page.getNumber());
    }
}
