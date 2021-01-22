package statemachine;

public enum CapsLock {

    UPPER_CASE{
        @Override
        CapsLock next() {
            return CapsLock.LOWER_CASE;
        }
    },
    LOWER_CASE{
        @Override
        CapsLock next() {
            return CapsLock.UPPER_CASE;
        }
    };

    abstract CapsLock next();
}
