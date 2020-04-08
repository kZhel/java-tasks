package ru.mail.polis.homework.analyzer;


/**
 * ������� ���������� �������, ���������� ����� ����������� ������ ��������������� � ���� ��� ������
 * ������� ������.
 * ���� ���� ����������� ������, ������� ������� ������� ��������� ���� (�� ��� ��� ���������� ���������, ��� ��� ���
 * ����� ���, ��� ��� �� ����� ���������� ����������, � ����� ������ ��������, ��� ��������� ����������� �������
 * ����� ���-�� ������������� �����). ���� ����������� ������ ��� ����� ��� �������� ������,
 * ��� �� ��� �������� ������� (������� �� ��������) � ���� "������������" �� ��������.
 * <p>
 * ��� �� ���������� ������� ��� ���������� ������, ������� ����� ��� ����� ��� ������� ������
 * �� ���� �������� � ������ TextFilterManager
 * <p>
 * 2 ����� + (2 ����� �� ������ ������ + 1 ���� �� ���� �� ���� ������) ����� 11
 */

public interface TextAnalyzer {

    static TextAnalyzer createTooLongAnalyzer(long maxLength) {

        return new TooLongFilter(maxLength);
    }

    static TextAnalyzer createSpamAnalyzer(String[] spam) {

        return new SpamFilter(spam);
    }

    static TextAnalyzer createNegativeTextAnalyzer() {

        return new NegativeTextFilter();
    }

    /**
     * ��������� ���� ������
     */
    static TextAnalyzer createCustomAnalyzer(String beginning) {

        return new CustomFilter(beginning);
    }

    FilterType analyze(String text);

    FilterType priority();
}
