package pl.terminal.server.domain.traveler.profile.languages;

import org.apache.commons.lang3.StringUtils;

public enum Language {
	AFRIKAANS,
	ALBANIAN,
	AMHARIC,
	ARABIC,
	ARAMAIC,
	ARMENIAN,
	ASSAMESE,
	AYMARA,
	AZERBAIJANI,
	BALOCHI,
	BAMANANKAN,
	BASHKORT,
	BASQUE,
	BELARUSAN,
	BENGALI,
	BHOJPURI,
	BISLAMA,
	BOSNIAN,
	BRAHUI,
	BULGARIAN,
	BURMESE,
	CANTONESE,
	CATALAN,
	CEBUANO,
	CHECHEN,
	CHEROKEE,
	CROATIAN,
	CZECH,
	DAKOTA,
	DANISH,
	DARI,
	DHOLUO,
	DUTCH,
	ENGLISH,
	ESPERANTO,
	ESTONIANEWE,
	FINNISH,
	FRENCH,
	GEORGIAN,
	GERMAN,
	GIKUYU,
	GREEK,
	GUARANI,
	GUJARATI,
	HAITIAN,
	CREOLE,
	HAUSA,
	HAWAIIAN,
	HEBREW,
	HILIGAYNON,
	HINDI,
	HUNGARIAN,
	ICELANDIC,
	IGBO,
	ILOCANO,
	INDONESIAN,
	INUIT_INUPIAQ,
	IRISH,
	GAELIC,
	ITALIAN,
	JAPANESE,
	JARAI,
	JAVANESE,
	KICHE,
	KABYLE,
	KANNADA,
	KASHMIRI,
	KAZAKH,
	KHMER,
	KHOEKHOE,
	KOREAN,
	KURDISH,
	KYRGYZ,
	LAO,
	LATIN,
	LATVIAN,
	LINGALA,
	LITHUANIAN,
	MACEDONIAN,
	MAITHILI,
	MALAGASY,
	MALAY,
	MALAYALAM,
	MANDARIN,
	MARATHI,
	MENDE,
	MONGOLIAN,
	NAHUATL,
	NAVAJO,
	NEPALI,
	NORWEGIAN,
	OJIBWA,
	ORIYA,
	OROMO,
	PASHTO,
	PERSIAN,
	POLISH,
	PORTUGUESE,
	PUNJABI,
	QUECHUA,
	ROMANI,
	ROMANIAN,
	RUSSIAN,
	RWANDA,
	SAMOAN,
	SANSKRIT,
	SERBIAN,
	SHONA,
	SINDHI,
	SINHALA,
	SLOVAK,
	SLOVENE,
	SOMALI,
	SPANISH,
	SWAHILI,
	SWEDISH,
	TACHELHIT,
	TAGALOG,
	TAJIKI,
	TAMIL,
	TATAR,
	TELUGU,
	THAI,
	TIBETIC,
	TIGRIGNA,
	TOK,
	PISIN,
	TURKISH,
	TURKMEN,
	UKRAINIAN,
	URDU,
	UYGHUR,
	UZBEK,
	VIETNAMESE,
	WARLPIRI,
	WELSH,
	WOLOF,
	XHOSA,
	YAKUT,
	YIDDISH,
	YORUBA,
	YUCATEC,
	ZAPOTEC,
	ZULU;

	public String getHumanName() {
		return StringUtils.capitalize(name().toLowerCase().replace("_", ""));
	}
}
