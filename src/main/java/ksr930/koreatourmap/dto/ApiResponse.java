package ksr930.koreatourmap.dto;

import lombok.Data;

import java.util.List;

@Data
public class ApiResponse {

    private Response response;

    @Data
    public static class Response {
        private Header header;
        private Body body;

        @Data
        public static class Header {
            private String resultCode;
            private String resultMsg;
        }

        @Data
        public static class Body {
            private int numOfRows;
            private int pageNo;
            private int totalCount;
            private Items items;

            @Data
            public static class Items {
                private List<Item> item;

                @Data
                public static class Item {
                    private String code;
                    private String name;
                    private String rnum;
                }
            }
        }
    }
}
