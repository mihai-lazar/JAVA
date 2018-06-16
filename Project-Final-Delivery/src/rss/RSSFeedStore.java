package rss;

public interface RSSFeedStore {
    void clear();
    void add(RSSItem currentItem);
}
