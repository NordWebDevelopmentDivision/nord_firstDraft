package is.nord.repository;

import is.nord.model.News;

import java.util.List;

/**
 * A storage for news items
 */
public interface NewsRepository {
    /**
     * Get all news items
     * @return a list of news items
     */
    List<News> getAll();

    /**
     * Adds a news item to the storage
     * @param news the news item to be added to the storage
     */
    void add(News news);
}
