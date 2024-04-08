public class FindingCountRowsToOutConsole extends FindingCountCharactersToFillConsole {
    public int calculateRowsToOutConsole(String text, int consoleWidth) {
        int _lines = 1;
        int _currentLineLength = 0;

        for (char c : text.toCharArray()) {
            if (c == '\n') {
                _lines++;
                _currentLineLength = 0;
            } else {
                _currentLineLength++;
                if (_currentLineLength > consoleWidth) {
                    _lines++;
                    _currentLineLength = 0;
                }
            }
        }
        return _lines;
    }
}
