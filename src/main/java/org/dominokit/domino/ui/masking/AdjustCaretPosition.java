package org.dominokit.domino.ui.masking;

public class AdjustCaretPosition {
    private static final int[] defaultArray = {};


    public int adjustCaretPosition(String previousConformedValue,
                                   String previousPlaceholder,
                                   int currentCaretPosition,
                                   String conformedValue,
                                   String rawValue,
                                   char placeholderChar,
                                   String placeholder,
                                   int[] indexesOfPipedChars,
                                   int[] caretTrapIndexes) {

        if (currentCaretPosition == 0 || rawValue.length() == 0) {
            return 0;
        }

        int rawValueLength = rawValue.length();
        int previousConformedValueLength = previousConformedValue.length();
        int placeholderLength = placeholder.length();
        int conformedValueLength = conformedValue.length();

        // This tells us how long the edit is. If user modified input from `(2__)` to `(243__)`,
        // we know the user in this instance pasted two characters
        int editLength = rawValueLength - previousConformedValueLength;

        // If the edit length is positive, that means the user is adding characters, not deleting.
        boolean isAddition = editLength > 0;

        // This is the first raw value the user entered that needs to be conformed to mask
        boolean isFirstRawValue = previousConformedValueLength == 0;
        // A partial multi-character edit happens when the user makes a partial selection in their
        // input and edits that selection. That is going from `(123) 432-4348` to `() 432-4348` by
        // selecting the first 3 digits and pressing backspace.
        //
        // Such cases can also happen when the user presses the backspace while holding down the ALT
        // key.
        boolean isPartialMultiCharEdit = editLength > 1 && !isAddition && !isFirstRawValue;

        // This algorithm doesn't support all cases of multi-character edits, so we just return
        // the current caret position.
        //
        // This works fine for most cases.
        if (isPartialMultiCharEdit) {
            return currentCaretPosition;
        }

        // For a mask like (111), if the `previousConformedValue` is (1__) and user attempts to enter
        // `f` so the `rawValue` becomes (1f__), the new `conformedValue` would be (1__), which is the
        // same as the original `previousConformedValue`. We handle this case differently for caret
        // positioning.
        boolean possiblyHasRejectedChar = isAddition && (previousConformedValue.equals(conformedValue) ||
                conformedValue.equals(placeholder));


        return 0;
    }
}
