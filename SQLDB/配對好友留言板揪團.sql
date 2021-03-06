
/****** Object:  Table [dbo].[MatchRequest]    Script Date: 2020/4/12 下午 09:27:41 ******/
DROP TABLE [dbo].[MatchRequest]
GO
/****** Object:  Table [dbo].[Matches]    Script Date: 2020/4/12 下午 09:27:41 ******/
DROP TABLE [dbo].[Matches]
GO
/****** Object:  Table [dbo].[Friends]    Script Date: 2020/4/12 下午 09:27:41 ******/
DROP TABLE [dbo].[Friends]
GO
/****** Object:  Table [dbo].[Events]    Script Date: 2020/4/12 下午 09:27:41 ******/
DROP TABLE [dbo].[Events]
GO
/****** Object:  Table [dbo].[EventDetails]    Script Date: 2020/4/12 下午 09:27:41 ******/
DROP TABLE [dbo].[EventDetails]
GO
/****** Object:  Table [dbo].[EventDetails]    Script Date: 2020/4/12 下午 09:27:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EventDetails](
	[EventId] [nchar](10) NULL,
	[ActualMembers] [nvarchar](100) NULL,
	[MembersId] [nchar](10) NULL,
	[MembersRate要再跟評分系統整合] [nchar](10) NULL,
	[EventsTime] [smalldatetime] NULL,
	[Place] [nvarchar](200) NULL,
	[PlacesRate] [int] NULL,
	[RequstDate] [smalldatetime] NULL,
	[ApproveDate] [smalldatetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Events]    Script Date: 2020/4/12 下午 09:27:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Events](
	[EventId] [int] IDENTITY(3,1) NOT NULL,
	[Title] [nvarchar](100) NULL,
	[ButtomNumbers] [int] NULL CONSTRAINT [DF_Events_ButtomNumbers]  DEFAULT ((1)),
	[TopNumbers] [int] NULL,
	[ActualMembers] [int] NULL,
	[EventDate] [smalldatetime] NULL,
	[Region] [nchar](10) NULL,
	[Description] [nvarchar](4000) NULL,
	[HolderId] [nchar](10) NULL,
	[RequestTime] [smalldatetime] NULL,
	[FreelyJoin] [bit] NULL,
	[Apoointment] [bit] NULL,
	[DueDay] [smalldatetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Friends]    Script Date: 2020/4/12 下午 09:27:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Friends](
	[FriendsListID] [nchar](10) NOT NULL,
	[MemberId] [nchar](10) NULL,
	[MemberId2] [nchar](10) NULL,
	[MessageID] [nchar](10) NULL,
	[MessageBy] [nchar](10) NULL,
	[Text] [nvarchar](4000) NULL,
	[MessageDate] [date] NULL,
	[MemberIdDelete] [bit] NULL,
	[MemberId2Delete] [bit] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Matches]    Script Date: 2020/4/12 下午 09:27:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Matches](
	[PairId] [int] IDENTITY(1,1) NOT NULL,
	[MatchId1] [nchar](10) NULL,
	[MatchId2] [nchar](10) NULL,
	[Friends1] [bit] NULL,
	[Friends2] [bit] NULL,
	[PairDate] [date] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[MatchRequest]    Script Date: 2020/4/12 下午 09:27:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MatchRequest](
	[MatchID] [int] IDENTITY(1,1) NOT NULL,
	[MemberID] [int] NOT NULL,
	[AgeTopLike] [int] NULL,
	[AgeBottomLike] [int] NULL,
	[LivingAreaLike] [nvarchar](12) NULL,
	[ShapeLike] [nvarchar](12) NULL,
	[GenderLike] [nvarchar](12) NULL,
	[RestaurantTypeLike] [nvarchar](20) NULL,
	[TourTypeLike] [nvarchar](20) NULL,
	[RequestDay] [date] NULL
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Events] ON 

INSERT [dbo].[Events] ([EventId], [Title], [ButtomNumbers], [TopNumbers], [ActualMembers], [EventDate], [Region], [Description], [HolderId], [RequestTime], [FreelyJoin], [Apoointment], [DueDay]) VALUES (1, N'簡單逛歷史博物館', 1, 2, NULL, CAST(N'2020-05-20 00:00:00' AS SmallDateTime), N'臺北市大安區    ', N'想找個人一起逛歷史博物館', NULL, CAST(N'2020-05-10 00:00:00' AS SmallDateTime), 1, 0, NULL)
INSERT [dbo].[Events] ([EventId], [Title], [ButtomNumbers], [TopNumbers], [ActualMembers], [EventDate], [Region], [Description], [HolderId], [RequestTime], [FreelyJoin], [Apoointment], [DueDay]) VALUES (2, N'礦業老街團拍漫遊', 1, 10, NULL, CAST(N'2020-05-17 00:00:00' AS SmallDateTime), N'新北市樹林區    ', N'礦業老街團拍，請先聯繫XX工作室，最後出團視當天天候', NULL, CAST(N'2020-05-01 00:00:00' AS SmallDateTime), 0, 1, CAST(N'2020-05-08 00:00:00' AS SmallDateTime))
INSERT [dbo].[Events] ([EventId], [Title], [ButtomNumbers], [TopNumbers], [ActualMembers], [EventDate], [Region], [Description], [HolderId], [RequestTime], [FreelyJoin], [Apoointment], [DueDay]) VALUES (3, N'淡水一日遊', 5, 10, NULL, CAST(N'2020-06-28 00:00:00' AS SmallDateTime), N'新北市淡水區    ', N'一日淡水漫遊(警官宿舍、八角樓、海事博物館、紅樓)', NULL, CAST(N'2020-06-02 00:00:00' AS SmallDateTime), 0, 1, CAST(N'2020-06-18 00:00:00' AS SmallDateTime))
INSERT [dbo].[Events] ([EventId], [Title], [ButtomNumbers], [TopNumbers], [ActualMembers], [EventDate], [Region], [Description], [HolderId], [RequestTime], [FreelyJoin], [Apoointment], [DueDay]) VALUES (4, N'踢足球揪團', 10, 30, NULL, CAST(N'2020-05-09 00:00:00' AS SmallDateTime), N'新北市新店區    ', N'新店陽光運動公園，草地自擺框，下雨取消，請自備深淺色背心', NULL, CAST(N'2020-05-02 00:00:00' AS SmallDateTime), 0, 1, CAST(N'2020-05-08 00:00:00' AS SmallDateTime))
INSERT [dbo].[Events] ([EventId], [Title], [ButtomNumbers], [TopNumbers], [ActualMembers], [EventDate], [Region], [Description], [HolderId], [RequestTime], [FreelyJoin], [Apoointment], [DueDay]) VALUES (5, N'九份二日遊', 4, 4, NULL, CAST(N'2020-04-25 00:00:00' AS SmallDateTime), N'新北市瑞芳區    ', N'團玩九份老街+燈街夜景', NULL, CAST(N'2020-04-01 00:00:00' AS SmallDateTime), 0, 1, CAST(N'2020-04-11 00:00:00' AS SmallDateTime))
INSERT [dbo].[Events] ([EventId], [Title], [ButtomNumbers], [TopNumbers], [ActualMembers], [EventDate], [Region], [Description], [HolderId], [RequestTime], [FreelyJoin], [Apoointment], [DueDay]) VALUES (6, N'揪看書(國父紀念館)', 1, 2, NULL, CAST(N'2020-04-26 00:00:00' AS SmallDateTime), N'臺北市信義區    ', N'揪看書', NULL, CAST(N'2020-04-25 00:00:00' AS SmallDateTime), 1, 0, NULL)
SET IDENTITY_INSERT [dbo].[Events] OFF
