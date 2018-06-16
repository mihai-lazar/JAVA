package asistentePOO;

import java.util.ArrayList;

import rss.RSSFeedReader;
import rss.RSSItem;
import rss.stores.ArrayListRSSFeedStore;

public class RSS {
	
	static ArrayListRSSFeedStore feedStore = new ArrayListRSSFeedStore();
	
	public static void main(String[] args) 
	{
		
		RSSFeedReader.read("http://rss.cnn.com/rss/edition_world.rss", feedStore);
		ArrayList<RSSItem> list = feedStore.getList();
		
		for (RSSItem rssItem : list) {
			if(rssItem.getTitle() != null) {
			  System.out.println("guid: " + rssItem.getGuid());
			  System.out.println("title: " + rssItem.getTitle());
			  System.out.println("description: " + rssItem.getDescription());
			  System.out.println("link: " + rssItem.getLink());
			  System.out.println("");
			}
		}
		
	}

}
