package optional;

import java.util.ArrayList;
import java.util.List;

public class Chart {
    private String chartName;
    private List<Album> albumList;

    public Chart(String chartName) {
        this.chartName = chartName;
        albumList=new ArrayList<>();
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }
    public void addAlbum(Album album)
    {
        albumList.add(album);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
         stringBuilder.append(this.chartName);
         stringBuilder.append("\n");
         for(Album album:albumList)
         {
             stringBuilder.append(album);
             stringBuilder.append(" ");
         }
         return stringBuilder.toString();
    }
}
