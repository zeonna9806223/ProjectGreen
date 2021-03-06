USE [YI]
GO
/****** Object:  Table [dbo].[MemberInterested]    Script Date: 2020/4/13 下午 12:12:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MemberInterested](
	[InterestedID] [nchar](10) NULL,
	[InterestedHobby] [nvarchar](40) NULL,
	[InterestedMovieType] [nvarchar](40) NULL,
	[InterestedMusicType] [nvarchar](40) NULL,
	[InterestedReadingType] [nvarchar](40) NULL,
	[InterestedFoodType] [nvarchar](40) NULL,
	[InterestedRestaurantType] [nvarchar](40) NULL,
	[InterestedFitLook] [nvarchar](10) NULL,
	[InterestedHeightTop] [int] NULL,
	[InterestedHeightBtm] [int] NULL,
	[InterestedWeightTop] [int] NULL,
	[InterestedWeightBtm] [int] NULL,
	[InterestedRelationship] [nvarchar](20) NULL
) ON [PRIMARY]
GO
