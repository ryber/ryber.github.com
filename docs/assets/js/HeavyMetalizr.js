/*!
 * HeavyMetalizr - lib/HeavyMetalizr.js
 * Copyright(c) 2013 Ryan Bergman <ryan.bergman@gmail.com>
 * MIT Licensed
 */

"use strict";

exports.HeavyMetalizr = function(text) {
	text = text.replace(/ae/g, unescape("%E6"))
	text = text.replace(/AE/g, unescape("%C6"))
	text = text.replace(/a/g, unescape("%E4"))
	text = text.replace(/A/g, unescape("%C4"))
	text = text.replace(/e/g, unescape("%EB"))
	text = text.replace(/E/g, unescape("%CB"))
	text = text.replace(/o/g, unescape("%F6"))
	text = text.replace(/O/g, unescape("%D6"))
	text = text.replace(/u/g, unescape("%FC"))
	text = text.replace(/U/g, unescape("%DC"))
	text = text.replace(/B/g, unescape("%DF"))
	text = text.replace(/D/g, unescape("%D0"))
	
	return text
}