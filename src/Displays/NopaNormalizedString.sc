NopaNormalizedString : NopaCenterableString {

	*new {
		arg units = "", digits = 3, scale = 1, centered = false;
		var p = super.new();
		p.init(units, digits, scale, centered);
		^ p;
	}

	init {
		arg a_units = "", a_digits = 3, a_scale = 1, a_centered = false;
		this.digits = a_digits;
		this.units = a_units;
		this.scale = a_scale;
		centered = a_centered;
		^ this;
	}

	map {
		arg n;
		var s;
		n = this.getFromParam(n).linlin(0, 1, this.lowerBound(), 1) * scale;
		s = this.shorten(n.round(10 ** digits.neg), 0) ++ units;
		^ s;
	}

	unmap {
		arg param, n;
		param.normalized = (this.parse(n)).linlin(this.lowerBound(), 1, 0, 1);
	}

	getFromParam {
		arg n;
		if (n.isKindOf(NopaAbstractParam)) {
			n = n.normalized;
		};
		^ n;
	}

}
