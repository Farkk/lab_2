public class FindingCountCharactersToFillConsole implements IConsoleLayoutManager  {
    private int _consoleWidth;

    @Override
    public int calculateCharsToFillLastLine(int consoleWidth, String text) {
        setConsoleWidth(consoleWidth);
        int textLength = text.length();
        int remainder = textLength % _consoleWidth;
        int charsToFillLastLine = 0;

        if (remainder > 0) {
            charsToFillLastLine = _consoleWidth - remainder;
        }

        return charsToFillLastLine;
    }

    public int getConsoleWidth() {
        return _consoleWidth;
    }

    public void setConsoleWidth(int consoleWidth) {
        this._consoleWidth = consoleWidth;
    }
}
