TestSS2ParamDisplayPercent : TestSS2ParamDisplay {
  var display;

  setUp {
    display = SS2ParamDisplayPercent(scale: 20);
  }

  tearDown {
    display.free;
  }

  test_new {
    this.assertEquals(display.units, "%");
    this.assertEquals(display.scale, 100);
  }
}