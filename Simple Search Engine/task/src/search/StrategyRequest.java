package search;

public enum StrategyRequest {
    ALL, ANY, NONE, INVALID_STRATEGY;

    public static StrategyRequest getStrategyRequest(String request) {
        try {
            return StrategyRequest.valueOf(request.toUpperCase());
        } catch (IllegalArgumentException e) {
            return INVALID_STRATEGY;
        }
    }
    public static SearchMethod getMethod(StrategyRequest request) {
        switch (request) {
            case ALL:
                return new AllSearchMethod();
            case ANY:
                return new AnySearchMethod();
            case NONE:
                return new NoneSearchMethod();
            default:
                return null;
        }
    }
}
