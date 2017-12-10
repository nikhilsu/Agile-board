package com.prorg.helper;

public class QueryStatus {
    private static final int SOME_MAGIC_NUMBER = -1;
    private int serialId;
    private boolean status;

    private QueryStatus(int serialId, boolean status) {
        this.serialId = serialId;
        this.status = status;
    }

    public static QueryStatus Success(int serialId) {
        return new QueryStatus(serialId, true);
    }

    public static QueryStatus Failure() {
        return new QueryStatus(SOME_MAGIC_NUMBER, false);
    }

    public boolean isSuccessful() {
        return status;
    }

    public int serialId() throws Exception {
        if (serialId == SOME_MAGIC_NUMBER)
            throw new Exception("Save failed, no serial id");
        return serialId;
    }
}
