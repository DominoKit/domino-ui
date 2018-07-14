package org.dominokit.domino.ui.masking;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;

public class PatternEvaluationTest extends TestCase {

    private static final String FIXED = "FIXED";
    private final PatternDefinition testDefinition = new PatternDefinition() {
        @Override
        public char keyChar() {
            return '%';
        }

        @Override
        public boolean isMatch(char c) {
            return false;
        }
    };

    private PatternEvaluation newPatternEvaluation(String pattern) {
        return new PatternEvaluation(pattern);
    }

    @Test
    public void givenEmptyPattern_whenGetDisplayValue_thenValueShouldBeEmpty() {
        assertThat(newPatternEvaluation("").getDisplayValue()).isEmpty();
    }

    @Test
    public void givenCreatedPatternEvaluation_thenShouldHaveDefaultPatternDefinitions() {
        PatternEvaluation patternEvaluation = newPatternEvaluation("");
        assertThat(patternEvaluation.getPatternDefinitions()).size().isEqualTo(3);
        assertThat(patternEvaluation.getPatternDefinitions().stream().map(PatternDefinition::keyChar)).containsOnly('a', '*', '0');
    }

    @Test
    public void givenEmptyPatternDefinitions_whenAddDefinition_thenDefinitionShouldBeAdded() {
        PatternEvaluation patternEvaluation = PatternEvaluation.pattern("").addDefinition(testDefinition).build();
        assertThat(patternEvaluation.getPatternDefinitions()).contains(testDefinition);
    }

    @Test
    public void givenPatternContainsNoDefinitionsCharacters_whenGetDisplayValue_thenShouldBeEqualToPattern() {
        assertThat(newPatternEvaluation(FIXED).getDisplayValue()).isEqualTo(FIXED);
    }

    @Test
    public void givenPatternContainsOneCharWithDefinition_whenGetDisplayValue_thenShouldReplaceThatCharWithPlaceholderChar() {
        assertThat(newPatternEvaluation("0").getDisplayValue()).isEqualTo("_");
    }

    @Test
    public void givenPatternContainsCharsWithDefinitionAndOnesWithNoDefinitions_whenGetDisplayValue_thenShouldReplaceDefinitionsWithPlaceholderChar() {
        assertThat(newPatternEvaluation("SOME0DEFS").getDisplayValue()).isEqualTo("SOME_DEFS");
        assertThat(newPatternEvaluation("SOME0DEFSaCHARS").getDisplayValue()).isEqualTo("SOME_DEFS_CHARS");
        assertThat(newPatternEvaluation("SOME0DEFS*ALL").getDisplayValue()).isEqualTo("SOME_DEFS_ALL");
    }

    @Test
    public void givenPatternContainsOptionalPart_whenGetDisplayValue_thenShouldRemoveTheOptionalPart() {
        assertThat(newPatternEvaluation("SOME[OPTIONAL]PARTS").getDisplayValue()).isEqualTo("SOMEOPTIONALPARTS");
    }

    @Test
    public void givenPatternContainsCustomDefinition_whenGetDisplayValue_thenShouldReplaceWithPlaceholderChar() {
        PatternEvaluation patternEvaluation = PatternEvaluation.pattern("SOME%%PARTS").addDefinition(testDefinition).build();
        assertThat(patternEvaluation.getDisplayValue()).isEqualTo("SOME__PARTS");
    }

    @Test
    public void givenEmptyPattern_whenInputNewValue_thenUnMaskedValueShouldBeEmpty() {
        assertThat(newPatternEvaluation("").input("value").getUnMaskedValue()).isEmpty();
    }

    @Test
    public void givenPatternWithNoDefinitions_whenInputNewValue_thenUnMaskedValueShouldBeEqualsToPattern() {
        assertThat(newPatternEvaluation(FIXED).input("value").getUnMaskedValue()).isEmpty();
    }

    @Test
    public void givenPatternWithOnlyDefinitions_whenInputNewValueThatDoesNotMatchPattern_thenUnMaskedValueShouldBeEmpty() {
        assertThat(newPatternEvaluation("0").input("value").getUnMaskedValue()).isEmpty();
        assertThat(newPatternEvaluation("0").input("a2").getUnMaskedValue()).isEqualTo("2");
    }

    @Test
    public void givenPatternWithOnlyDefinitions_whenInputNewValueThatMatchPattern_thenUnMaskedValueShouldBeEqualsToInput() {
        assertThat(newPatternEvaluation("0").input("2").getUnMaskedValue()).isEqualTo("2");
        assertThat(newPatternEvaluation("00a*").input("12pm").getUnMaskedValue()).isEqualTo("12pm");
    }

    @Test
    public void givenPatternWithOnlyDefinitions_whenInputValueGreaterThanPattern_thenUnMaskedValueShouldBeEqualsToFirstMatchedChars() {
        assertThat(newPatternEvaluation("0").input("22").getUnMaskedValue()).isEqualTo("2");
    }

    @Test
    public void givenPatternWithDefinitionsAndFixedParts_whenInputNewValueThatDoesNotMatchPattern_thenUnMaskedValueShouldBeEmpty() {
        assertThat(newPatternEvaluation("0PM").input("2").getUnMaskedValue()).isEqualTo("2");
        assertThat(newPatternEvaluation("PM0").input("2").getUnMaskedValue()).isEqualTo("2");
        assertThat(newPatternEvaluation("PM0a*MP").input("2n2").getUnMaskedValue()).isEqualTo("2n2");
        assertThat(newPatternEvaluation("PM0aFIXEDa*MP").input("2nn2").getUnMaskedValue()).isEqualTo("2nn2");
        assertThat(newPatternEvaluation("PM0aFIXEDa*MP").input("nnn2").getUnMaskedValue()).isEqualTo("2");
    }

    @Test
    public void givenPatternWithSingleDefinition_whenInputValueThatMatchesThePattern_thenDisplayValueShouldHaveTheInput() {
        assertThat(newPatternEvaluation("FIXED0").input("1").getDisplayValue()).isEqualTo("FIXED1");
    }

    @Test
    public void givenPatternWithMultiDefinitions_whenInputValueThatMatchesThePattern_thenDisplayValueShouldHaveTheInput() {
        assertThat(newPatternEvaluation("0a-FIXED-a0").input("2nn2").getDisplayValue()).isEqualTo("2n-FIXED-n2");
    }

    @Test
    public void givenPatternWithOptionalParts_whenInputValueWithNoOptionalPart_thenDisplayValueShouldHaveTheInput() {
        assertThat(newPatternEvaluation("0a-FIXED[aa]-a0").input("2nn2").getDisplayValue()).isEqualTo("2n-FIXEDn-__");
        assertThat(newPatternEvaluation("0a-FIXED[aa]-a0").input("2abcd2").getDisplayValue()).isEqualTo("2a-FIXEDbc-d2");
    }

    @Test
    public void givenPatternWithDefinitionsAndFixedParts_whenInputValuesTwice_thenUnMaskedValueShouldBeEqualsToBothOfTheInputs() {
        assertThat(newPatternEvaluation("FIXED00").input("1").input("2").getUnMaskedValue()).isEqualTo("12");
    }

    @Test
    public void givenPatternWithDefinitionsAndFixedParts_whenInputValuesWithUnmatchPartsTwice_thenUnMaskedValueShouldBeEqualsToBothOfTheMatchedInputs() {
        assertThat(newPatternEvaluation("FIXED00").input("a1").input("b2").getUnMaskedValue()).isEqualTo("12");
    }

    @Test
    public void givenPatternWithDefinitionsAndFixedParts_whenInputValuesTwice_thenDisplayValueShouldMatchInput() {
        assertThat(newPatternEvaluation("FIXED00").input("1").input("2").getDisplayValue()).isEqualTo("FIXED12");
    }

    @Test
    public void givenPatternWithOptionalParts_whenInputValuesTwice_thenDisplayValueShouldMatchInput() {
        assertThat(newPatternEvaluation("FIXED00[**]").input("12").input("ab").getDisplayValue()).isEqualTo("FIXED12ab");
    }

    @Test
    public void givenEmptyPattern_whenBackspace_thenTheUnmaskedValueShouldBeEmpty() {
        assertThat(newPatternEvaluation("").backspace().getUnMaskedValue()).isEqualTo("");
    }

    @Test
    public void givenFixedPattern_whenBackspace_thenTheUnmaskedValueShouldBeEmpty() {
        assertThat(newPatternEvaluation("FIXED").backspace().getUnMaskedValue()).isEqualTo("");
    }

    @Test
    public void givenPatternWithOneDefinition_whenBackspace_thenTheUnmaskedValueShouldBeEmpty() {
        assertThat(newPatternEvaluation("FIXED0").backspace().getUnMaskedValue()).isEqualTo("");
    }

    @Test
    public void givenPatternWithOneDefinition_whenInputThenBackspace_thenTheUnmaskedValueShouldBeEmpty() {
        assertThat(newPatternEvaluation("FIXED0").input("1").backspace().getUnMaskedValue()).isEqualTo("");
    }

    @Test
    public void givenPatternWithTwoDefinitions_whenInputThenBackspaceTwice_thenTheUnmaskedValueShouldBeEmpty() {
        assertThat(newPatternEvaluation("FIXED00")
                .input("1")
                .input("2")
                .backspace()
                .backspace()
                .getUnMaskedValue()).isEqualTo("");
    }

    @Test
    public void givenPatternWithTwoDefinitions_whenInputTwiceThenBackspace_thenTheUnmaskedValueShouldHaveTheFirstInput() {
        assertThat(newPatternEvaluation("FIXED00")
                .input("1")
                .input("2")
                .backspace()
                .getUnMaskedValue()).isEqualTo("1");
    }

    @Test
    public void givenPatternWithTwoDefinitions_whenInputTwiceThenBackspace_thenTheDisplayValueShouldHaveTheFirstInput() {
        assertThat(newPatternEvaluation("FIXED00")
                .input("1")
                .input("2")
                .backspace()
                .getDisplayValue()).isEqualTo("FIXED1_");
    }

    @Test
    public void givenPatternWithTwoDefinitionsAndFixedParts_whenInputTwiceThenBackspace_thenTheDisplayValueShouldMatchTheInput() {
        assertThat(newPatternEvaluation("FIXED0-0")
                .input("1")
                .input("2")
                .backspace()
                .backspace()
                .getDisplayValue()).isEqualTo("FIXED_-_");
    }

    @Test
    public void givenEmptyPattern_whenBackspaceAtIndexOutOfRange_thenTheUnmaskedValueShouldBeEmpty() {
        assertThat(newPatternEvaluation("")
                .deleteAt(-1)
                .getUnMaskedValue()).isEqualTo("");
    }

    @Test
    public void givenFixedPattern_whenBackspaceAtIndexOutOfRange_thenTheUnmaskedValueShouldBeEmpty() {
        assertThat(newPatternEvaluation("FIXED")
                .deleteAt(-1)
                .getUnMaskedValue()).isEqualTo("");
    }

    @Test
    public void givenFixedPattern_whenBackspaceAtIndex_thenTheUnmaskedValueShouldBeEmpty() {
        assertThat(newPatternEvaluation("FIXED")
                .deleteAt(0)
                .getUnMaskedValue()).isEqualTo("");
    }

    @Test
    public void givenPatternWithOneDefinition_whenInputAndBackspaceAtIndexLessThanTheInputIndex_thenTheUnmaskedValueShouldBeEqualsToTheInput() {
        assertThat(newPatternEvaluation("FIXED0")
                .input("1")
                .deleteAt(0)
                .getUnMaskedValue()).isEqualTo("1");
    }

    @Test
    public void givenPatternWithOneDefinition_whenInputAndBackspaceAtIndexEqualsToInputIndex_thenTheUnmaskedValueShouldBeEmpty() {
        assertThat(newPatternEvaluation("FIXED0")
                .input("1")
                .deleteAt(5)
                .getUnMaskedValue()).isEqualTo("");
    }

    @Test
    public void givenPatternWithMultiDefinitionAndFixedPart_whenInputAndBackspace_thenTheUnmaskedValueShouldBeMatchTheInput() {
        assertThat(newPatternEvaluation("**a-FIXED-00")
                .input("12b45")
                .deleteAt(11)
                .deleteAt(1)
                .getUnMaskedValue()).isEqualTo("1b4");
    }

    @Test
    public void givenPatternWithOneDefinition_whenInputAndBackspaceAtIndexLessThanTheInputIndex_thenTheDisplayValueShouldHaveTheInput() {
        assertThat(newPatternEvaluation("FIXED0")
                .input("1")
                .deleteAt(0)
                .getDisplayValue()).isEqualTo("FIXED1");
    }

    @Test
    public void givenPatternWithOneDefinition_whenInputAndBackspaceAtIndexEqualsToInputIndex_thenTheDisplayValueShouldNotHaveTheInput() {
        assertThat(newPatternEvaluation("FIXED0")
                .input("1")
                .deleteAt(5)
                .getDisplayValue()).isEqualTo("FIXED_");
    }

    @Test
    public void givenPatternWithMultiDefinitionAndFixedPart_whenInputAndBackspace_thenTheDisplayValueShouldBeMatchTheInput() {
        assertThat(newPatternEvaluation("**a-FIXED-00")
                .input("12b45")
                .deleteAt(1)
                .getDisplayValue()).isEqualTo("1b_-FIXED-45");

        assertThat(newPatternEvaluation("**a-FIXED[00]-00")
                .input("12b4567")
                .deleteAt(2)
                .getDisplayValue()).isEqualTo("12_-FIXED45-67");
    }


    @Test
    public void givenPatternWithMultiDefinitionFixedPartAndOptionalPart_whenInputAndBackspaceAnOptionalChar_thenTheDisplayValueShouldBeMatchTheInput() {
        assertThat(newPatternEvaluation("**a-FIXED[00]-00")
                .input("12b4567")
                .deleteAt(9)
                .getDisplayValue()).isEqualTo("12b-FIXED56-7_");
    }

    @Test
    public void givenPatternWithMultiDefinition_whenInputAndBackspaceAtIndexThenInputAgain_thenTheDisplayValueShouldBeMatchTheInput() {
        assertThat(newPatternEvaluation("**a-FIXED[00]-00")
                .input("12b4567")
                .deleteAt(9)
                .input('9', 13)
                .getDisplayValue()).isEqualTo("12b-FIXED56-79");

        assertThat(newPatternEvaluation("**a-FIXED[00]-00")
                .input("12b4567")
                .deleteAt(2)
                .input('r', 2)
                .getDisplayValue()).isEqualTo("12r-FIXED45-67");


    }

    @Test
    public void givenPatternWithMultiDefinition_whenInputAndBackspaceAtIndexThenInputAtTheSameIndex_thenTheDisplayValueShouldBeMatchTheInput() {
        assertThat(newPatternEvaluation("000a-")
                .input('1')
                .input('2', 1)
                .input('3', 2)
                .input('a', 3)
                .deleteAt(2)
                .input('8', 2)
                .getDisplayValue()).isEqualTo("128a-");
    }


    @Test
    public void givenPatternWithMultiDefinition_whenInputAndBackspaceAtIndexTwiceThenInputAgainAtTheSameIndex_thenTheDisplayValueShouldBeMatchTheInput() {
        assertThat(newPatternEvaluation("000a-")
                .input('1')
                .input('2', 1)
                .input('3', 2)
                .input('a', 3)
                .deleteAt(2)
                .deleteAt(1)
                .input('8', 1)
                .getDisplayValue()).isEqualTo("18_a-");
    }

    @Test
    public void givenPatternWithMultiDefinition_whenInputAndBackspaceAtIndexTheFirstIndex_thenTheDisplayValueShouldBeMatchTheInput() {
        assertThat(newPatternEvaluation("000a-")
                .input("123a")
                .deleteAt(0)
                .getDisplayValue()).isEqualTo("23_a-");
    }

    @Test
    public void givenPatternWithFixedPartAtTheLast_whenInputAndBackspace_thenTheDisplayValueShouldBeMatchTheInput() {
        assertThat(newPatternEvaluation("000a-")
                .input("123a")
                .backspace()
                .getDisplayValue()).isEqualTo("123_-");
    }

    @Test
    public void whenAddingValueChangeListener_thenShouldBeCalledOnceTheValueWasChanged() {
        AtomicBoolean calledOnInputString = new AtomicBoolean(false);
        newPatternEvaluation("000a-").addValueChangeListener(() -> {
            calledOnInputString.set(true);
        }).input("123b");

        assertThat(calledOnInputString.get()).isTrue();

        AtomicBoolean calledOnInputChar = new AtomicBoolean(false);
        newPatternEvaluation("000a-").addValueChangeListener(() -> {
            calledOnInputChar.set(true);
        }).input('1');

        assertThat(calledOnInputChar.get()).isTrue();

        AtomicBoolean calledOnBackspace = new AtomicBoolean(false);
        PatternEvaluation patternEvaluation = newPatternEvaluation("000a-").input("123a");
        patternEvaluation.addValueChangeListener(() -> {
            calledOnBackspace.set(true);
        }).backspace();

        assertThat(calledOnBackspace.get()).isTrue();
    }

    @Test
    public void givenEmptyPattern_whenDeleteAt_thenTheDisplayValueShouldBeEmpty() {
        assertThat(newPatternEvaluation("").input("123").deleteAt(0).getDisplayValue()).isEmpty();
    }

    @Test
    public void givenPatternWithFixedPartsOnly_whenDeleteAt_thenTheDisplayValueShouldBeEqualsToPattern() {
        assertThat(newPatternEvaluation(FIXED).input("123").deleteAt(0).getDisplayValue()).isEqualTo(FIXED);
    }

    @Test
    public void givenPatternWithOptionalPartContainsCharsDontHaveDefinitions_whenInput_thenDisplayValueShouldMatchTheInput() {
        assertThat(newPatternEvaluation("aaa[0-]000").input("aaa123").getDisplayValue()).isEqualTo("aaa1-23_");
    }

    @Test
    public void givenPatternWithOneDefinition_whenDeleteAt_thenTheDisplayValueShouldMatchThePattern() {
        assertThat(newPatternEvaluation("0").deleteAt(0).getDisplayValue()).isEqualTo("_");
    }

    @Test
    public void givenPatternWithOneDefinition_whenInputMatchedCharThenDeleteAt_thenTheDisplayValueShouldMatchThePattern() {
        assertThat(newPatternEvaluation("0").input("1").deleteAt(0).getDisplayValue()).isEqualTo("_");
    }

    @Test
    public void givenPatternWithMoreThanOneDefinition_whenInputMatchedCharThenDeleteAt_thenTheDisplayValueShouldMatchThePattern() {
        assertThat(newPatternEvaluation("000").input("123").deleteAt(0).getDisplayValue()).isEqualTo("23_");
        assertThat(newPatternEvaluation("000-000").input("123-456").deleteAt(4).getDisplayValue()).isEqualTo("123-56_");
    }

    @Test
    public void givenPatternWithMultipleDefinitions_whenInputThenDeleteAtAtIndexDoesNotMatchedOtherChars_thenTheDisplayValueShouldMatchThePattern() {
        assertThat(newPatternEvaluation("000a-000").input("123b456").deleteAt(3).getDisplayValue()).isEqualTo("123_-456");
    }

    @Test
    public void givenPatternWithMultipleDefinitions_whenChangePlaceholderChar_thenDisplayValueShouldBeEvaluatedWithTheNewChar() {
        assertThat(newPatternEvaluation("000a-000").setPlaceholderChar('^').input("123b").getDisplayValue()).isEqualTo("123b-^^^");
    }

    @Test
    public void givenPatternWithPartsThatShouldBeAddedToTheUnmaskedValue_whenInputAndGetUnmaskedValue_thenTheUnmaskedValueShouldHaveTheseParts() {
        assertThat(newPatternEvaluation("{#}000a-000").input("123b").getUnMaskedValue()).isEqualTo("#123b");
    }

    @Test
    public void givenPatternWithPreventShiftSymbol_whenInputAndDeleteAtIndex_thenTheCharsShouldNoBeShifted() {
        assertThat(newPatternEvaluation("00`0-`000").input("123456").deleteAt(1).getDisplayValue()).isEqualTo("1_3-456");
        assertThat(newPatternEvaluation("{#}000a[aaa]/NIC-`*[**]").input("123g")
                .input('1', 13)
                .input('2', 14)
                .input('3')
                .getDisplayValue()).isEqualTo("#123g/NIC-123");
    }

    public void testName() {
        assertThat(newPatternEvaluation("https://000.0[00].0[00].0[00]:00[00]")
                .input("127.0.0.1:8080")
                .getDisplayValue()).isEqualTo("https://127.0.0.1:8080");
    }
}
