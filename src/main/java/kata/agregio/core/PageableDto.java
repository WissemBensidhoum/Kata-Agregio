package kata.agregio.core;

import java.util.List;

public record PageableDto<T>(List<T> content, int totalPages, long totalElements, int pageNumber) {

}