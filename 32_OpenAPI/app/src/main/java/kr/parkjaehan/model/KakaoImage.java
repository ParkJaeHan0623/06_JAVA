package kr.parkjaehan.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class KakaoImage {
    @SerializedName("documents")
    private List<Document> documents;

    @SerializedName("meta")
    private Meta meta;

    @Data
    public class Document {
        @SerializedName("collection")
        private String collection;

        @SerializedName("thumbnail_url")
        private String thumbnailUrl;

        @SerializedName("image_url")
        private String imageUrl;

        @SerializedName("width")
        private int width;

        @SerializedName("height")
        private int height;

        @SerializedName("display_sitename")
        private String displaySiteName;

        @SerializedName("doc_url")
        private String docUrl;

        @SerializedName("datetime")
        private String datetime;

    }

    @Data
    public class Meta {
        @SerializedName("total_count")
        private int totalCount;

        @SerializedName("pageable_count")
        private int pageableCount;

        @SerializedName("is_end")
        private boolean isEnd;
    }
}

