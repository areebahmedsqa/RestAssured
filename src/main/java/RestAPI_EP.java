public class RestAPI_EP {
    public enum ENDPOINTS {
        EP_GETACTIVITIES("/api/v1/Activities"),
        EP_POSTACTIVITIES("/api/v1/Activities"),
        EP_GETACTIVITYBYID("/api/v1/Activities/"),
        EP_PUTACTIVITYBYID("/api/v1/Activities/"),
        EP_DELETEACTIVITYBYID("/api/v1/Activities/"),
        EP_GETAUTHORS("/api/v1/Authors"),
        EP_GETAUTHORSBYID("/api/v1/Authors/"),
        EP_POSTAUTHOR("/api/v1/Authors"),
        EP_PUTAUTHORBYID("/api/v1/Authors/"),
        EP_DELETEAUTHORBYID("/api/v1/Authors/");

        private String strEndPoint;

        ENDPOINTS(String strEndPoint) {
            this.strEndPoint = strEndPoint;
        }

        public String strGet_URL() {
            return strEndPoint;
        }
    }
}
