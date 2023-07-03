package fantasyAdventure;

//無効な入力のカスタム例外
class InvalidCommandException extends Exception {
    InvalidCommandException(String msg) {
        super(msg);
    }
}
