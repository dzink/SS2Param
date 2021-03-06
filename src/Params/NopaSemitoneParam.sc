NopaSemitoneParam : NopaContinuousParam {

  ensureDefaultDisplay {
    if (displayStrategy.isNil) {
      this.displayStrategy_(NopaSemitoneString());
    };
  }

  semitones {
    arg n;
    n = n ? value;
    ^ n;
  }

  semitones_ {
    arg st;
    this.value = st;
    ^ this;
  }

  ratio {
    arg n;
    n = (n ? value).midiratio;
    ^ n;
  }

  ratio_ {
    arg ratio;
    this.value = ratio.ratiomidi;
  }

  hz {
    arg n;
    n = (n ? value).midicps;
    ^ n;
  }

  hz_ {
    arg ratio;
    this.value = ratio.cpsmidi;
  }

  transformOut {
    arg n = nil;
    if (prCachedTransform.isNil) {
      n = n ? this.value;
      n = switch(conversionStrategy,
        \hz, { this.hz(n) },
        \ratio, { this.ratio(n) },
        n
      );
      prCachedTransform = n;
    };
    ^ prCachedTransform;
  }

  convertToHz {
    ^ conversionStrategy == \hz;
  }

  convertToHz_ {
    arg convert = true;
    conversionStrategy = if (convert, {\hz}, {\none});
    ^ this;
  }

  convertToRatio {
    ^ conversionStrategy == \ratio;
  }

  convertToRatio_ {
    arg convert = true;
    conversionStrategy = if (convert, {\ratio}, {\none});
    ^ this;
  }

  validConversionStrategies {
    ^ [\none, \hz, \ratio];
  }

}
