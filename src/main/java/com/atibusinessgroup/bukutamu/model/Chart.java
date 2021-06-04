package com.atibusinessgroup.bukutamu.model;

import java.util.List;

public class Chart {
	public boolean animationEnabled;
	public Tooltip toolTip;
	public AxisX axisX;
    public AxisY axisY;
	public List<Data> data;
    public String colorSet;

	public static class Tooltip{
		public boolean shared;

		public boolean isShared() {
			return shared;
		}

		public void setShared(boolean shared) {
			this.shared = shared;
		}


	}

	public static class AxisX{
		public int interval;
        public String title;
		public int getInterval() {
			return interval;
		}

		public void setInterval(int interval) {
			this.interval = interval;
		}

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class AxisY{
        public String title;
        public String valueFormatString;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getValueFormatString() {
            return valueFormatString;
        }

        public void setValueFormatString(String valueFormatString) {
            this.valueFormatString = valueFormatString;
        }
    }
	public static class Data{
		public String type;
		public String name;
		public String legendText;
		public String toolTipContent;
		public boolean showInLegend;
		public int axisYIndex;
		public List<DataPoint> dataPoints;

		public static class DataPoint{
			public String label;
			public double y;
			public String getLabel() {
				return label;
			}
			public void setLabel(String label) {
				this.label = label;
			}
			public double getY() {
				return y;
			}
			public void setY(double y) {
				this.y = y;
			}


		}

        public String getToolTipContent() {
            return toolTipContent;
        }

        public void setToolTipContent(String toolTipContent) {
            this.toolTipContent = toolTipContent;
        }

        public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLegendText() {
			return legendText;
		}

		public void setLegendText(String legendText) {
			this.legendText = legendText;
		}

		public boolean isShowInLegend() {
			return showInLegend;
		}

		public void setShowInLegend(boolean showInLegend) {
			this.showInLegend = showInLegend;
		}

		public int getAxisYIndex() {
			return axisYIndex;
		}

		public void setAxisYIndex(int axisYIndex) {
			this.axisYIndex = axisYIndex;
		}

		public List<DataPoint> getDataPoints() {
			return dataPoints;
		}

		public void setDataPoints(List<DataPoint> dataPoints) {
			this.dataPoints = dataPoints;
		}


	}
	public boolean isAnimationEnabled() {
		return animationEnabled;
	}
	public void setAnimationEnabled(boolean animationEnabled) {
		this.animationEnabled = animationEnabled;
	}
	public Tooltip getToolTip() {
		return toolTip;
	}
	public void setToolTip(Tooltip toolTip) {
		this.toolTip = toolTip;
	}
	public AxisX getAxisX() {
		return axisX;
	}
	public void setAxisX(AxisX axisX) {
		this.axisX = axisX;
	}
	public List<Data> getData() {
		return data;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}

    public AxisY getAxisY() {
        return axisY;
    }

    public void setAxisY(AxisY axisY) {
        this.axisY = axisY;
    }

    public String getColorSet() {
        return colorSet;
    }

    public void setColorSet(String colorSet) {
        this.colorSet = colorSet;
    }
}
