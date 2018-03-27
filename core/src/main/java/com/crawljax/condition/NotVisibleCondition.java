package com.crawljax.condition;

import net.jcip.annotations.Immutable;

import java.util.Objects;

import com.crawljax.browser.EmbeddedBrowser;
import com.crawljax.core.state.Identification;
import com.google.common.base.MoreObjects;

/**
 * Conditions that returns true iff element found with By is visible.
 * 
 * @author dannyroest@gmail.com (Danny Roest)
 */
@Immutable
public class NotVisibleCondition implements Condition {

	private final VisibleCondition visibleCondition;

	/**
	 * @param identification
	 *            the identification.
	 */
	public NotVisibleCondition(Identification identification) {
		this.visibleCondition = new VisibleCondition(identification);
	}

	@Override
	public boolean check(EmbeddedBrowser browser) {
		return Logic.not(visibleCondition).check(browser);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getClass(), visibleCondition);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof NotVisibleCondition) {
			NotVisibleCondition that = (NotVisibleCondition) object;
			return Objects.equals(this.visibleCondition, that.visibleCondition);
		}
		return false;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
		        .add("visibleCondition", visibleCondition)
		        .toString();
	}

}
