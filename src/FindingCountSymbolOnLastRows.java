public class FindingCountSymbolOnLastRows extends FindingCountRowsToOutConsole {
    @Override
    public int calculateCharsToFillLastLine(int consoleWidth, String text) {
        int _lastLineLength = text.length() % consoleWidth;
        return _lastLineLength == 0 ? consoleWidth : _lastLineLength - 1;
    }
}
