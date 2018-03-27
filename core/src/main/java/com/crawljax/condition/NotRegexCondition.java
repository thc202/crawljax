package com.crawljax.condition;

import net.jcip.annotations.Immutable;

import java.util.Objects;

import com.crawljax.browser.EmbeddedBrowser;
import com.google.common.base.MoreObjects;

/**
 * A condition which returns true iff the expression does NOT occur in the DOM.
 * 
 * @author dannyroest@gmail.com (Danny Roest)
 */
@Immutable
public class NotRegexCondition implements Condition {

	private final RegexCondition regexCondition;

	/**
	 * @param expression
	 *            the regular expression.
	 */
	public NotRegexCondition(String expression) {
		this.regexCondition = new RegexCondition(expression);
	}

	@Override
	public boolean check(EmbeddedBrowser browser) {
		return Logic.not(regexCondition).check(browser);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getClass(), regexCondition);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof NotRegexCondition) {
			NotRegexCondition that = (NotRegexCondition) object;
			return Objects.equals(this.regexCondition, that.regexCondition);
		}
		return false;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
		        .add("regexCondition", regexCondition)
		        .toString();
	}

}
