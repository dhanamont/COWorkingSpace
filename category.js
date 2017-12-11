                            $(function () {

                                var $show = $("#show"),
                                    $sub = $(".subcat");

                                $show.on("change", function () {
                                    var _rel = $(this).val();
                                    $sub.find("option").attr("style", "");
                                    $sub.val("");
                                    if (!_rel)
                                        return $sub.prop("disabled", true);
                                    $sub.find("[rel=" + _rel + "]").show();
                                    $sub.prop("disabled", false);

 
                                });



                            });
