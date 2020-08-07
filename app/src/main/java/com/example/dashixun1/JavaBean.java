package com.example.dashixun1;

public class JavaBean {

    /**
     * end_time : 1893340800
     * id : 3
     * restrictions : {"display_rate":300,"max_display_count":1000000}
     * start_time : 1497369600
     * title : 儿歌点点-A
     * video : {"duration":3072,"url":"http://video5lmv.ergedd.com/magnets/3_a_480.mp4"}
     * weight : 5
     */

    private int end_time;
    private int id;
    private RestrictionsBean restrictions;
    private int start_time;
    private String title;
    private VideoBean video;
    private int weight;

    public int getEnd_time() {
        return end_time;
    }

    public void setEnd_time(int end_time) {
        this.end_time = end_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RestrictionsBean getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(RestrictionsBean restrictions) {
        this.restrictions = restrictions;
    }

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public VideoBean getVideo() {
        return video;
    }

    public void setVideo(VideoBean video) {
        this.video = video;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static class RestrictionsBean {
        /**
         * display_rate : 300
         * max_display_count : 1000000
         */

        private int display_rate;
        private int max_display_count;

        public int getDisplay_rate() {
            return display_rate;
        }

        public void setDisplay_rate(int display_rate) {
            this.display_rate = display_rate;
        }

        public int getMax_display_count() {
            return max_display_count;
        }

        public void setMax_display_count(int max_display_count) {
            this.max_display_count = max_display_count;
        }
    }

    public static class VideoBean {
        /**
         * duration : 3072
         * url : http://video5lmv.ergedd.com/magnets/3_a_480.mp4
         */

        private int duration;
        private String url;

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
