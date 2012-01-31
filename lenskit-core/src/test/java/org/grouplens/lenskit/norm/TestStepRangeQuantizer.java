/*
 * LensKit, an open source recommender systems toolkit.
 * Copyright 2010-2011 Regents of the University of Minnesota
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package org.grouplens.lenskit.norm;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * @author Michael Ekstrand
 */
public class TestStepRangeQuantizer {
    @Test
    public void testMakeValues() {
        double[] vals = StepRangeQuantizer.makeValues(0.5, 5.0, 0.5);
        double[] evals = { 0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0 };
        assertArrayEquals(evals, vals, 1.0e-6);
    }

    @Test
    public void testHalfStars() {
        Quantizer q = new StepRangeQuantizer(0.5, 5.0, 0.5);
        assertThat(q.getValue(q.apply(4.9)), closeTo(5.0, 1.0e-6));
        assertThat(q.getValue(q.apply(4.7)), closeTo(4.5, 1.0e-6));
        assertThat(q.getValue(q.apply(3.42)), closeTo(3.5, 1.0e-6));
    }
}