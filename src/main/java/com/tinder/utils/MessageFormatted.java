package com.tinder.utils;

public class MessageFormatted {
    private final String format;
    private final Object[] params;

    public MessageFormatted(final String msg) {
        this(msg, new Object[0]);
    }

    public MessageFormatted(final String msg, final Object... params) {
        this.format = msg;
        this.params = params;
    }

    public String get() {
        return params.length == 0 ?
                this.format :
                String.format(format, params);
    }

    @Override
    public String toString() {
        return get();
    }
}
