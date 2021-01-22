package statemachine;

public enum SeatHeater {

    TURN_OFF {
        @Override
        SeatHeater nxt() {
            return SeatHeater.STATE_THREE;
        }
    },
    STATE_THREE {
        @Override
        SeatHeater nxt() {
            return SeatHeater.STATE_TWO;
        }
    },
    STATE_TWO {
        @Override
        SeatHeater nxt() {
            return SeatHeater.STATE_ONE;
        }
    },
    STATE_ONE {
        @Override
        SeatHeater nxt() {
            return SeatHeater.TURN_OFF;
        }
    };

    abstract SeatHeater nxt();

}
