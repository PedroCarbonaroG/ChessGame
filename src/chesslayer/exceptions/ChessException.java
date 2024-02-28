package chesslayer.exceptions;

import boardlayer.exceptions.BoardException;

public class ChessException extends BoardException {
    
    public ChessException(String exceptionMsg) {
        super(exceptionMsg);
    }
}
